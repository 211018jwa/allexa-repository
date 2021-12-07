let logoutBtn = document.querySelector('#logout');

logoutBtn.addEventListener('load', async () => {
    let res = await fetch('http://localhost:8080/checkloginstatus');

    if(res.status === 200) {
        let userObj = await res.json();

        if(userObj.userRole === 'associate') {
            window.location.href = 'associate-homepage.html';
        }
        else if(userObj.userRole === 'trainer') {
            window.location.href = 'trainer-homepage.html';
        }
    }
});
