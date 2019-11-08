def powerSet(string):
    for i in range(len(string)):
        powerSetRec("",i,string)


def powerSetRec(soFar,i,string):
    s = soFar+string[i]
    print s
    for j in range(i+1,len(string)):
        powerSetRec(s,j,string)

    
                     


def binary(string,n):
    print string

    if n==0:
        return
    else:
        binary(string+"0",n-1)
        binary(string+"1",n-1)


        
    
def permutation(string):
    return permutationRec("",string)

def permutationRec(sub,string):
    if len(string)==0:
        print sub
    else:
        for i in range(len(string)):
            permutationRec(sub+string[i],string[0:i]+string[i+1:])
    

def reverse(string):
    return reverseRec("",string)

def reverseRec(sub,string):
    if len(string)==0:
        return sub
    else:
        return reverseRec(sub+string[-1],string[0:-1])


def isPalindrome(word):
    if len(word)==0 or len(word)==1:
        return True
    if word[0]!=word[-1]:
        return False
    else:
        return isPalindrome(word[1:-1])



def palBack(word):
    for i in range(len(word)):
        reverseStr = reverse(word[0:i])
        palCheck = word+reverseStr
        if isPalindrome(palCheck):
            print palCheck

    
def palFront(word):
    for i in range(len(word)-1,-1,-1):
        reverseStr = reverse(word[i:len(word)])
        palCheck = reverseStr+word
        if isPalindrome(palCheck):
            print palCheck
            break


def binarize(string,n):
    if n<=0:
        print string
    else:
        string = str(n%2)+string
        binarize(string,n/2)
    
def brackets(n):
    bracketsRec("",n,n)

def bracketsRec(string,left,right):
    if left == 0 and right ==0:
        print string
        
    if left>0:
        bracketsRec(string+"(",left-1,right)
    if right > left:
        bracketsRec(string+")",left,right-1)

