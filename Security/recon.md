`recon-ng`

`marketplace install all`

`modules search`

`workspaces create pentest1`

`workspaces list`

`modules search whois`

`modules load recon/domains-contacts/whois_pocs`

`info`

`options set SOURCE microsoft.com`

`run`

`modules search bing`

`modules load recon/domains-hosts/bing_domain_web`

`info`

`options set SOURCE microsoft.com`

`run`

`show hosts`

`show contacts`

`dashboard`

`modules search report`

`modules load reporting/html`

`info`

`options set CREATOR Bhupend`

`options set CUSTOMER MS_Target`

`options set FILENAME /home/bhupend/Desktop/Pentest1-report.html`

`run`

## Use recon web

`recon-web`
