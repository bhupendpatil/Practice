const request = require('request')

const url = 'http://api.openweathermap.org/data/2.5/weather?q=mumbai&appid=01e53f477bdf75e22b9f6af871249a9e'

request({url:url},(error,response)=>{
    const data = JSON.parse(response.body)
    console.log(data.weather[0].main)
})