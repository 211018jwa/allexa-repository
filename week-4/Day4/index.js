let bodyElement = document.body;

//let div = document.createElement('h1');

let div = document.createElement('div');

div.innerHTML = '<h1>Hello World!</h1>';
//div.innerText = 'Hello World!';
//div.textContent = 'Hello World!';

bodyElement.appendChild(div);

let firstDiv = document.querySelector('#first-div');
console.log(firstDiv.textContent);
console.log(firstDiv.innerText);
console.log(firstDiv.innerHTML);

div.remove();

let imgElement = document.querySelector('img');
imgElement.setAttribute('src', 'https://upload.wikimedia.org/wikipedia/en/thumb/3/30/Java_programming_language_logo.svg/1200px-Java_programming_language_logo.svg.png');
imgElement.setAttribute('width', '100');

let firstDivChildren = firstDiv.children;
console.log(firstDivChildren);

firstDivChildren[0].style.color = 'red';
firstDivChildren[0].style.backgroundColor = 'gray';

firstDivChildren[1].style.color = 'cyan';
firstDivChildren[1].style.backgroundColor = 'red';

let students = [];

students.push ({
    'id' : 1,
    'firstName' : 'John',
    'lastName' : 'Doe',
    'classification' : 'Freshman',
    'age' : 18
});

students.push ({
    'id' : 2,
    'firstName' : 'Jane',
    'lastName' : 'Doe',
    'classification' : 'Senior',
    'age' : 22
});

students.push ({
    'id' : 3,
    'firstName' : 'Bach',
    'lastName' : 'Tran',
    'classification' : 'Freshman',
    'age' : 18
});

let studentTable = document.querySelector('#student-table');
let studentTableTbody = studentTable.querySelector('tbody');

function populateTableData () {
    studentTableTbody.innerHTML = '';
    
    for(let i = 0; i < students.length; i++) {
        let student = students[i];
    
        let tr = document.createElement('tr');
        
        let td1 = document.createElement('td');
        let td2 = document.createElement('td');
        let td3 = document.createElement('td');
        let td4 = document.createElement('td');
        let td5 = document.createElement('td');
    
        td1.innerText = student.id;
        td2.innerText = student.firstName;
        td3.innerText = student.lastName;
        td4.innerText = student.classification;
        td5.innerText = student.age;
    
        tr.appendChild(td1);
        tr.appendChild(td2);
        tr.appendChild(td3);
        tr.appendChild(td4);
        tr.appendChild(td5);
    
        studentTableTbody.appendChild(tr);
    }
}

populateTableData();

let button = document.querySelector('#demo-button');

let buttonClickArrowFunction = () => {
    let studentIDInputElement = document.querySelector('#student-id-input');
    let firstNameInputElement = document.querySelector('#first-name-input');
    let lastNameInputElement = document.querySelector('#last-name-input');
    let classificationInputElement = document.querySelector('#classification-dropdown');
    let ageInputElement = document.querySelector('#age-input');

    let newStudent = {
        'id' : studentIDInputElement.value,
        'firstName' : firstNameInputElement.value,
        'lastName' : lastNameInputElement.value,
        'classification' : classificationInputElement.value,
        'age' : ageInputElement.value 
    };
    students.push(newStudent);

    populateTableData();
}

document.addEventListener('click', buttonClickArrowFunction);
