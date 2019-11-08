#all permutations of same length
def _perm(prefix, s,arr):
	# print(prefix,s)
	if len(s) == 0:
		arr.append(prefix)
	for i in range(len(s)):
	 	_perm(prefix+s[i],s[:i]+s[i+1:],arr)

def perm(s):
	arr = []
	_perm("",s,arr)
	return arr

# print(perm("abc"))


#all permutations of same length
def _permAll(prefix, s,arr):
	if len(prefix) > 0:
		arr.append(prefix)
	for i in range(len(s)):
	 	_permAll(prefix+s[i],s[:i]+s[i+1:],arr)

def permAll(s):
	arr = []
	_permAll("",s,arr)
	return arr

# print(permAll("abc"))



#all permutations of same length
def _permUnique(prefix, s,arr):
	if len(prefix) > 0:
		arr.append(prefix)
	for i in range(len(s)):
	 	_permUnique(prefix+s[i],s[i+1:],arr)

def permUnique(s):
	arr = []
	_permUnique("",s,arr)
	return arr

print(permUnique("abc"))


#permutations of count
def _permCount(prefix, s,l):
	if l == 0:
		print(prefix)
		return 
	for i in range(len(s)):
	 	_permCount(prefix+s[i],s[:i]+s[i+1:],l-1)

def permCount(s,l):
	_permCount("",s,l)

# permCount("abc",3)


#Is Anagram Palindrome possible
# This problem is basically same as Check if characters of a given string can be rearranged to form a palindrome. We can do it in O(n) time using a count array. Following are detailed steps.
# # 1) Create a count array of alphabet size which is typically 256. Initialize all values of count array as 0.
# 2) Traverse the given string and increment count of every character.
# 3) Traverse the count array and if the count array has more than one odd values, return false. Otherwise return true.


# ## find out if 3 numbers sum up

a = [1,4,9,11,5,3]
k = 5
def find3Sum(a,k):
	a.sort()
	for i in range(len(a)):
		total = a[i]
		left = i+1
		right = len(a)-1
		while (left < right):
			new_total = total + a[left]+a[right]
			if new_total > k:
				right -= 1
			elif new_total < k:
				left += 1
			else:
				return (total,a[left],a[right])
	return False


# print (find3Sum(a,k))


# a = [1,4,9,11,5,3]
# k = 12
def shift(a,k):
	k =  k % len(a)
	for i in range(k):
		front = a.pop()
		a.insert(0,front)
	return a

# print (shift(a,k))


# Length of Longest Common Substring  
  
# Returns length of longest common  
# substring of X[0..m-1] and Y[0..n-1]  
def LCSubStr(X, Y): 

# Create a table to store lengths of 
# longest common suffixes of substrings.  
# Note that LCSuff[i][j] contains the  
# length of longest common suffix of  
# X[0...i-1] and Y[0...j-1]. The first 
# row and first column entries have no 
# logical meaning, they are used only 
# for simplicity of the program. 

# LCSuff is the table with zero  
# value initially in each cell 
	m = len(X)
	n = len(Y)
	LCSuff = [[0 for k in range(n+1)] for l in range(m+1)] 

# To store the length of  
# longest common substring 
	result = 0 

# Following steps to build 
# LCSuff[m+1][n+1] in bottom up fashion 
	for i in range(m + 1): 
		for j in range(n + 1): 
			if (i == 0 or j == 0): 
				LCSuff[i][j] = 0
			elif (X[i-1] == Y[j-1]): 
				LCSuff[i][j] = LCSuff[i-1][j-1] + 1
				result = max(result, LCSuff[i][j]) 
			else: 
				LCSuff[i][j] = 0
	print(LCSuff)
	return result 

print(LCSubStr('Hi',"Hitler"))

