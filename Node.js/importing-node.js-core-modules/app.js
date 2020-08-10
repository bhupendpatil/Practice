const fs = require('fs')

fs.writeFileSync('note.txt','My name is Bhupend Patil')

fs.appendFileSync('note.txt','\nI\'m 24')