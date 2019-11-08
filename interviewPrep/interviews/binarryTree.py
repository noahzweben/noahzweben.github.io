# -*- coding: utf-8 -*-
##
##         10
##        0
##          2
##        1   4
##          3   6
##             5   8
##               7   9

class Node:
    def __init__(self,value,left,right):
        self.value = value
        self.left = left
        self.right = right
        


class Tree:
    def __init__(self):
        self.root = None
        self.loadTree()
        
        
    def realAdd(self,node,value):
        if self.root==None:
            self.root = Node(value,None,None)
            return
        if node == None:
            return Node(value,None,None)
        if value<node.value:
            node.left = self.realAdd(node.left,value)
        if value>node.value:
            node.right = self.realAdd(node.right,value)
        return node

    def dancer(self, node):
        if node != None:
            self.dancer(node.left)
            print node.value
            self.dancer(node.right)
            
    def printMe(self):
        self.dancer(self.root)

    
    def add(self,value):
        self.realAdd(self.root,value)

    def contains(self, value):
        return self.containsRec(self.root,value)

    def containsRec(self, node, value):
        if node == None:
            return False
        if value<node.value:
            return self.containsRec(node.left,value)
        elif value>node.value:
            return self.containsRec(node.right,value)
        else:
            return True


    def findAncestor(self,value1,value2):
        return self.findAncRec(self.root,value1,value2)


    def findAncRec(self,node,value1,value2):
        if node == None:
            return None

        if self.containsRec(node,value1)==False or self.containsRec(node,value2)==False:
            return None

        if (self.containsRec(node.left,value1) and self.containsRec(node.left,value2)):
            return self.findAncRec(node.left,value1,value2)

        if (self.containsRec(node.right,value1) and self.containsRec(node.right,value2)):
            return self.findAncRec(node.right,value1,value2)

        else:
            return node.value
        


    def loadTree(self):
        self.add(10)
        for i in range(0,10,2):
            self.add(i)
        for i in range(1,10,2):
            self.add(i)

    def distance(self,value):
        return self.distanceRec(self.root,value,0)

    def distanceRec(self,node,value,dist):
        if node == None:
            return None
        if value == node.value:
            return dist
        if value<node.value:
            return self.distanceRec(node.left,value,dist+1)
        if value>node.value:
            return self.distanceRec(node.right,value,dist+1)

    def distanceBetween(self,value1,value2):
        dist1= self.distance(value1)
        dist2 = self.distance(value2)
        if dist1 == None or dist2 == None:
            return None
        distAncestor = self.distance(self.findAncestor(value1,value2))
        return dist1+dist2-2*distAncestor

me = Tree()
    
