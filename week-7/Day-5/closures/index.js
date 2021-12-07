function myFunction() {

}

let anonFunction = function() {

}

let arrowFunction = () => {

}

let functions = (function() {
    let x;

    function getX() {
        return x;
    }

    function setX(param) {
        x = param;
    }

    return [getX, setX];
})();

functions[1]('my string 1');
console.log(functions[0]());

