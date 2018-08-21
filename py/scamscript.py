import requests
import os
import random
import string
import json

url = '' #insert url here

names = json.loads(open('names.json').read())

chars = string.ascii_letters + string.digits + '!@#$%^&*()'
random.seed = (os.urandom(1024))

for name in names:
	name_extra = ''.join(random.choice(string.digits))
	
	username = name.lower() + name_extra + '@gmail.com'
	password = ''.join(random.choice(chars) for i in range(8))
	
	requests.post(url, allow_redirects=False, data ={
		'': username,
		'': password
	})
	
	print 'sending username %s and password %s' % (username, password)

