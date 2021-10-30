############################
#	James Wagner
#	CSC 4125/5125 Spring 2021
#	Data Generator
############################

import random

#Our parameters
customers = 50
suppliers = 25
parts = 100
orders = 300

def get_insert(table, data):
	#Returns a proper SQL INSERT statement using the table and values passed
	for i in range(len(data)):
		if str(data[i]).find("to_date") > -1:
			pass			
		elif data[i] is None:
			data[i] = "NULL"
		elif type(data[i]) is str:
			data[i] = "'%s'" % data[i]
		elif type(data[i]) is int:
			data[i] = str(data[i])
		else:
			data[i] = str(data[i])	
	sql = "INSERT INTO %s VALUES (%s);\n" % (table, ", ".join(data))
	return sql

def get_random_phone_number():
	#Returns a random phone number
	return "%s%s%s-%s%s%s-%s%s%s%s" % tuple([random.randint(0,9) for x in range(10)])

def get_random_name():
	#Returns a random name
	names = ["Matthew H.", "Rebecca", "Courtney", "Jennifer", "Lisa", "Shakayla", "Phi", "Kayla", "Hai", "Tyler", "Osayd", "Kenny", "Albert", "Joseph", "Kevin", "Rocco", "Norman", "Matthew O.", "Jarnell", "Cooper"]
	return random.choice(names)
	
def get_random_city():
	#Returns a random city
	cities = ["Austin", "Boston", "Chicago", "Detroit", "Eugene", "Flint", "Gary", "Houston", "Irvine", "Jackson", "Kansas City", "Lincoln", "Milwaukee", "New York", "Oakland", "Philadelphia", "Quebec City", "Rockford", "San Jose", "Tulsa", "Vancouver", "Wichita"]
	return random.choice(cities)

def get_random_date():
	#Returns a random date
	return "to_date('%s/%s/20%s', 'dd/mm/yyyy')" % (str(random.randint(1,28)).zfill(2), str(random.randint(1,12)).zfill(2), str(random.randint(0,20)).zfill(2))

def get_random_partname():
	names = ["Monster Truck", "Jet Pack", "Jet", "Hover Board", "Light Saber", "Flux Capacitor", "Time Machine", "T800", "T1000", "Laser", "Proton Pack", "Gremlin", "HAL 9000", "Buzz Lightyear", "DeLorean", "Dr. Jones Whip", "Dr. Jones Hat", "Orca Fishing Boat", "Box of Chocolates", "Royale with Cheese", "Reese''s Pieces", "Dinosaur", "Alien", "Apple", "Book", "Car", "Desk", "Elephant", "Fish", "Giraffe", "Kangaroo", "Lamp"]
	return random.choice(names)
	
def get_random_color():
	colors = ["Red", "Orange", "Yellow", "Green", "Blue", "Purple", "Violet", "Maroon", "Pink", "Gold", "Silver", "Cyan", "Turquoise", "Indigo", "Magenta", None]
	return random.choice(colors)
	
def get_random_price():
	return float(random.randrange(1, 200000))/100
	
def get_random_size():
	return random.randrange(1, 200)

def get_random_customer():
	return random.randrange(1, customers + 1)

def get_random_supplier():
	return random.randrange(1, suppliers + 1)

def get_random_part():
	return random.randrange(1, parts + 1)

def get_random_shipmode():
	modes = ["Air", "Boat", "Truck", "Train"]
	return random.choice(modes)	
	
def generate_customers():
	data = []
	for i in range(customers):
		record = [i + 1, get_random_name(), get_random_city(), get_random_phone_number()]
		data.append(record)
	return data
	
def generate_suppliers():
	data = []
	for i in range(suppliers):
		record = [i + 1, get_random_name(), get_random_city(), get_random_phone_number()]
		data.append(record)
	return data

def generate_parts():
	data = []
	for i in range(parts):
		record = [i + 1, get_random_partname(), get_random_color(), get_random_size(), get_random_price()]
		data.append(record)
	return data
	
def generate_orders():
	data = []
	for i in range(orders):
		record = [i + 1, get_random_customer(), get_random_supplier(), get_random_part(), get_random_date(), get_random_shipmode()]
		data.append(record)
	return data
	
	
data = {'Customer': generate_customers(), 'Supplier': generate_suppliers(), 'Part': generate_parts(), 'Orders': generate_orders()}	
out = open("SQL_practice_set1_inserts.sql", "w")
for key, value in data.items():
	for record in value:
		out.write(get_insert(key, record))
	out.write("\ncommit;\n\n")
out.close()



