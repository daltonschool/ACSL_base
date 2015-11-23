#Name: Russell Kaplan
#School: Dalton
#School Code: 3055
def convert(bits):
    res = "".join(["*" if len(set([bit[i] for bit in bits])) != 1 else bits[0][i] for i in range(len(bits[0]))])
    return res if 2 ** res.count("*") == len(bits) else "NONE"

for answer in [convert(list(set(raw_input().split(", ")[1:]))) for i in range(5)]: print answer