// const square = function(x){
//     return x * x
// }

// const square = (x) => x * x

// const square = (x) => {
//     return x * x
// }

// console.log(square(3))

const event = {
    name: 'Birthday Party',
    guestList: ['Bhupend','Harshad','Hitesh'],
    printGuestList() {
        console.log('Guest list for '+ this.name)
        this.guestList.forEach((guest) => {
            console.log(guest + ' is attending ' + this.name)
        })
    }
}

event.printGuestList()