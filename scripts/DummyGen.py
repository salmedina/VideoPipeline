import random

def DummyVWFileGen(dummyFileName, totalVW,  minDocLen, maxDocLen):	
	#Select a random length of the document
	docLen = random.randrange(minDocLen, maxDocLen, 1)
	vwList = random.sample(range(totalVW), docLen) 

	dummyFile = open(dummyFileName, 'w')
	for vw in vwList:
	  dummyFile.write("%s " % vw)
	print("SUCCESS: %s  Len: %d"%(dummyFileName,docLen) )

def main():
	#Total centroids found
	totalVW = 10
	#Dummy generator params
	minDocLen = 5
	maxDocLen = 10
	
	##Generate the files
	for id in range(10):
		#the .vw extension is used for visual word files
		fileName = ".\\IMG_%d.vw"%(id)
		DummyVWFileGen(fileName, totalVW, minDocLen, maxDocLen)

if __name__ == "__main__":
    main()