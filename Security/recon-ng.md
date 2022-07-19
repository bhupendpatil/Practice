# Reconnaissance with recon-ng

### help
`help`

### installing modules
`marketplace install all`

### creating workspace
`workspaces <create|list|load|remove> [...]`

eg. `workspaces create re-cars`

### using db module
`db <delete|insert|notes|query|schema> [...]`

`db schema`

`db insert domains`

`tesla.com`

`show domains`

### using modules
`modules <load|reload|search> [...]`

`modules search hack`

`modules load recon/domains-hosts/hackertarget`

`info`

### the option command
`options <list|set|unset> [...]`

`options list`

### setting values to the options of the module
`options set <option> <value>`

#### Method 1:
`options set SOURCE default`

`run`

`options unset SOURCE`

#### Method 2: 
`options set SOURCE tesla.com`

`run`

#### Method 3:
`options set SOURCE /home/Bhupend/Desktop/targets.txt`

`run`

#### Method 4:
`options set SOURCE query select domain from domains where rowid=2`

`run`

### viewing results
`show hosts`

### Reporting
`modules search reporting`

`marketplace install reporting`

`modules load reporting/html`

`info`

`options set CREATOR Bhupend Patil`

`options set CUSTOMER CAR WORLD`

`options set FILENAME /home/Bhupend/Desktop/results.html`

`run`

### Pushpins

`workspaces create bhupend`

`marketplace install all`

`keys add flickr_api xxxxxxxxxxxxxx`

`keys add google_api xxxxxxxxxxxxxx`

`db insert locations`

#### add only value for street_address

`show locations`

`modules load recon/locations-locations/geocode`

`run`

`show locations`

`back`

`modules load recon/locations-pushpins/flickr`

`run`

`modules load reporting/pushpin`

`options set LATITUDE XX.XXXXX`

`options set LONGITUDE XX.XXXXX`

`options set RADIUS 1`

`run`