file_name = '1_submitInput.txt'
file_output = '1_output.txt'

def men_sim(n):
	return n//2 + n%2

with open(file_name) as file:
	content = file.read().splitlines()

output = open(file_output, 'w')
for n in content[1:]:
	output.write(str(men_sim(int(n))))
	output.write('\n')

output.close()
