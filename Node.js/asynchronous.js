console.log('Starting')

setTimeout(()=>{
    console.log('2 Sec Timer')
}, 2000)

setTimeout(()=>{
    console.log('0 sec Timer')
})

console.log('Stopping')


// Output
// Starting
// Stopping
// 0 sec Timer
// 2 Sec Timer