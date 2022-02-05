# sub array taht adds to zero 
def zeroArray(array):
    total = 0
    seenSum = {}
    for i in range(len(array)):
        total = total+array[i]
        if array[i]==0: #case with [1,0,5]
            return True
        if total == 0: #case with [-4,5,-1,6]
            return True
        if seenSum.has_key(total): #case with [-5,1,-1] zero group doesnt start at index of 0
            return True
        else:
            seenSum[total]= i
    return False


def subArraySum(arr, target):
    for i in range(len(arr)):
        curr_sum = arr[i]
        j = i+1
        while j <= len(arr):
            if curr_sum = target:
                return (i,j-1)
            if  j==len(arr):
                break
            curr_sum += arr[j]
            j += 1
    return False

#target subarray sum with hash
def subArraySumHash(arr,target):
    Map = {}
    curr_sum = 0
    for i in range(len(arr)):
        curr_sum += arr[i]
        if curr_sum == target:
            return (0,i) #sum between zero and i
        if (curr_sum - target in Map.keys()): #[2,1,3,-1], target=4... {2:0,2:1} 5-4 = -1, find index when we are X to much past
            print(arr[i], curr_sum,curr_sum-target)
            print(Map)
            return (Map[curr_sum-target]+1, i)
        Map[curr_sum] = i

subArraySumHash([1,2,3,-4,8],7)

#move zeroes to end of array
def moveZeroes(array):
    normalCount =0
    for i in range(len(array)):
        if array[i] != 0:
            array[normalCount]=array[i]
            normalCount = normalCount+1
    
    while (normalCount < len(array)):
        array[normalCount]=0
        normalCount += 1

# max sum in array
def maxSum(array):
    maxSum = array[0]
    currentSum = array[0]
    for i in range(1,len(array)):
        currentSum = max(currentSum+array[i],array[i]) #add to old or start with new
        maxSum = max(currentSum,maxSum)
    return maxSum
    

#target subarray sum



def checkSum(array,target):
    seenNumbs = []
    for i in array:
        if (target-i) in array:
            return True
        else:
            seenNumbs += [i]
    return False
