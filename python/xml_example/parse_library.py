#!/usr/bin/python



from xml.etree import ElementTree

root = ElementTree.parse('library.xml')

for b in root.findall('book'):
	print b.findtext('title')
	
# to count numbers of books
# count = 0 
# for b in root.findall('book'):
#	count += 1
#print count
