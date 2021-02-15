## Creating a File System on the Partition\

sudo su -

fdisk -l

fdisk /dev/sdb (can be anyname select your disk)

p

n

p

+1G

t

l

82

n

p

w