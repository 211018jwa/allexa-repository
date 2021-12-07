window.addEventListener('load', async () => {
    let res = await fetch('http://localhost:8080/checkloginstatus', {
        credentials: 'include',
        method: 'GET'
    });

    if(res.status === 401) {
        window.location.href = 'index.html';
    }

    populateTableWithAssignments();
});

let logoutBtn = document.querySelector('#logout');

logoutBtn.addEventListener('click', async () => {
    let res = await fetch('http://localhost:8080/logout', {
        method: 'POST',
        credentials: 'include'
    });

    if(res.status === 200) {
        window.location.href = 'index.html';
    }
})

async function populateTableWithAssignments() {
    let res = await fetch('http://localhost:8080/assignments', {
        credentials: 'include',
        method: 'GET'
    });

    let tbodyElement = document.querySelector("#assignment-table tbody");
    tbodyElement.innerHTML = '';
    let assignmentArray = await res.json();

    for(let i = 0; i < assignmentArray.length; i++) {
        let assignment = assignmentArray[i];

        let tr = document.createElement('tr');

        let td1 = document.createElement('td');
        td1.innerHTML = assignment.id;

        let td2 = document.createElement('td');
        td2.innerHTML = assignment.assignmentName;
        
        let td3 = document.createElement('td');
        let td4 = document.createElement('td');

        if(assignment.graderID != 0) {
            td3.innerHTML = assignment.grade;
            td4.innerHTML = assignment.graderID;
        } else {
            td3.innerHTML = 'Not graded';
            td4.innerHTML = '-';
        }

        let td5 = document.createElement('td');
        td5.innerHTML = assignment.authorID;

        let td6 = document.createElement('td');
        let viewImageButton = document.createElement('button');
        viewImageButton.innerHTML = 'view Image';
        td6.appendChild(viewImageButton);

        viewImageButton.addEventListener('click', () => {
            let assignmentImageModal = document.querySelector('#assignment-image-modal');

            let modalCloseElement = assignmentImageModal.querySelector('button');
            modalCloseElement.addEventListener('click', () => {
                assignmentImageModal.classList.remove('is-active');
            });

            let modalContentElement = assignmentImageModal.querySelector('.modal-content');
            modalContentElement.innerHTML = '';

            let imageElement = document.createElement('img');
            imageElement.setAttribute('scr', `http://localhost:8080/assignments/${assignment.id}/image`);
            modalContentElement.appendChild(imageElement);

            assignmentImageModal.classList.add('is-active');
        });

        tr.appendChild(td1);
        tr.appendChild(td2);
        tr.appendChild(td3);
        tr.appendChild(td4);
        tr.appendChild(td5);
        tr.appendChild(td6);

        tbodyElement.appendChild(tr);
    }
}

let assignmentSubmitButton = document.querySelector('#submit-assignment-btn');

assignmentSubmitButton.addEventListener('click', submitAssignment);

async function submitAssignment() {
    let assignmentNameInput = document.querySelector('#assignment-name');
    let assignmentImageInput = document.querySelector('#assignment-file');

    const file = assignmentImageInput.files[0];

    let formData = new FormData();
    formData.append('assignment_name', assignmentNameInput.value);
    formData.append('assignment_image', file);

    let res = await fetch('http://localhost:8080/assignments', {
        method: 'POST',
        credentials: 'include',
        body: formData
    });

    if(res.status === 201) {
        populateTableWithAssignments()
    } else if(res.status === 400) {
        let assigmentForm = document.querySelector('#assignment-submit-form');

        let data = await res.json();

        let pTag = document.createElement('p');
        pTag.innerHTML = data.message;
        pTag.style.color = 'red';

        assigmentForm.appendChild(pTag);
    }
}