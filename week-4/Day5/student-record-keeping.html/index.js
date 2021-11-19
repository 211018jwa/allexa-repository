let url = 'ec2-3-144-233-138.us-east-2.compute.amazonaws.com';

window.addEventListener('load', getAndPopulateStudents);

async function getAndPopulateStudents() {
    let res = await fetch(`http://${url}:8080/students`);

    let studentsArray = await res.json();

    populateStudentTable(studentsArray);
}

function populateStudentTable(array) {
    let tbody = document.querySelector('.main-section .table-container tbody');
    tbody.innerHTML = '';
    
    for(let personObject of array) {
        let tr = document.createElement('tr');

        let td1 = document.createElement('td');
        td1.innerText = personObject.id;
        let td2 = document.createElement('td');
        td2.innerText = personObject.firstNae;
        let td3 = document.createElement('td');
        td3.innerText = personObject.lastName;
        let td4 = document.createElement('td');
        td4.innerText = personObject.classification;
        let td5 = document.createElement('td');
        td5.innerText = personObject.age;

        tr.appendChild(td1);
        tr.appendChild(td2);
        tr.appendChild(td3);
        tr.appendChild(td4);
        tr.appendChild(td5);

        tbody.appendChild(tr);
    }
}

let studentSubmitButton = document.querySelector('#student-submit');
studentSubmitButton.addEventListener('click', async() => {
    let firstNameInputElement = document.querySelector('#first-name');
    let lastNameInputElement = document.querySelector('#last-name');
    let classificationInputElement = document.querySelector('#classification');
    let ageInputElement = document.querySelector('#age');

    let personObjectToAdd = {
        'firstName' : firstNameInputElement.value,
        'lastName' : lastNameInputElement.value,
        'classification' : classificationInputElement.value,
        'age' : ageInputElement.value
    };

    console.log(personObjectToAdd);

    let res = await fetch(`http://${url}:8080/students`, {
        method: 'POST',
        body: JSON.stringify(personObjectToAdd)
    });

    // if(res.status === 400) {
    //     let messageArray = await res.json();

    //     let formErrorOutputElement = document.querySelector('#form-error-output');
    //     formErrorOutputElement.innerHTML = '';

    //     for(let i = 0; i < messageArray.length; i++) {
    //         let message = messageArray[i];
            
    //         let pElement = document.createElement('p');
    //         pElement.innerHTML = message;
    //         formErrorOutputElement.appendChild(pElement);
    //     }

    // }

    getAndPopulateStudents();
});
