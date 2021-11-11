let someBoolean = '20' == 20;
console.log(someBoolean);

someBoolean = '20' === 20;
console.log(someBoolean);

if(1) {
    console.log('1 is treated as a truthy value');
}
if(-10) {
    console.log('-10 is treated as a truthy value');
}
if(0) {
    console.log('this will never print out. 0 is treated as a falsey value');
}
if(undefined) {
    console.log('this will never print out');
}
if(null)   {
    console.log('this will never print out');
}
if('')  {
    console.log('this will never print out');
}
if('ancxa') {
    console.log('this is a truthy value');
}