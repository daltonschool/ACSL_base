'''
Tom Delaney
The Dalton School: 3055
'''
def do(inp):
    strings = inp.split(', ')[1:]
    sets = []
    uniques = set('')
    for x in range(len(strings[0])): sets.append(set(''))
    for x in strings: 
        for y in range(len(strings[0])): 
            sets[y].add(x[y]) 
            uniques.add(x)
    output=''
    numofstars=0
    for x in range(len(strings[0])):
        if(len(sets[x])==2):
            output+='*'
            numofstars+=1
        else: output+=sets[x].pop()
    if(pow(2, numofstars) > len(uniques)): output = 'NONE'
    return output

outs = []
for x in range(5): outs.append(do(str(raw_input())))
for x in range(5): print outs[x]

