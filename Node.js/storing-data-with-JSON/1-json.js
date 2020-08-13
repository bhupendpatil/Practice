const fs = require('fs')

// const book = {
//     title: 'Bhupends guide',
//     author: 'Bhupend Patil'
// }

// const bookJSON = JSON.stringify(book)
// fs.writeFileSync('1-json.json',bookJSON)

// const dataBuffer = fs.readFileSync('1-json.json')
// const dataJSON = dataBuffer.toString()
// const data = JSON.parse(dataJSON)
// console.log(data.title)

const parsedData = JSON.parse(fs.readFileSync('1-json.json').toString())

parsedData.name = "Bhupend"
parsedData.age = 25

const changedData = JSON.stringify(parsedData)
fs.writeFileSync('1-json.json',changedData)