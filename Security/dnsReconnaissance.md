# DNS Reconnaissance

## DNS Recon
`dnsrecon -h`

`dnsrecon -d microsoft.com`

## Check zone transfer misconfiguration
`host zonetransfer.me`

`host -t ns zonetransfer.me`

`host -l zonetransfer.me nsztm1.digi.ninja`

`dnsenum zonetranfer.me`

## Automating OSINT
`ip addr`

### use ip of eth whatever your machine is connected to
`sudo spiderfoot -l 172.20.10.7:80`