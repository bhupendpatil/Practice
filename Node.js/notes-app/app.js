const chalk = require('chalk')
const yargs = require('yargs')
const getNotes = require('./notes.js')
const { describe } = require('yargs')

// Customize yargs version
yargs.version('1.1.0')

// Create add command
yargs.command({
    command: 'add',
    describe: 'Add a new note',
    builder: {
        title: {
            describe: 'Note title',
            demandOption: true,
            type: 'string'
        },
        body : {
            description: 'Note body',
            demandOption: true,
            type: 'string'
        },
    },
    handler: function(argv){
        console.log('Title: ' + argv.title)
        console.log('Body: ' + argv.body)
    }
})

// Create remove command
yargs.command({
    command:'remove',
    describe:'Remove a note',
    handler: function(){
        console.log('Remove the note')
    }
})

// Create list command
yargs.command({
    command:'list',
    describe:'List a note',
    handler: function(){
        console.log('List note')
    }
})

// Create read command
yargs.command({
    command:'read',
    describe:'Read a note',
    handler: function(){
        console.log('Read note')
    }
})

yargs.parse()
