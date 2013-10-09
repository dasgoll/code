#!/usr/bin/python



from xml.etree import ElementTree

root = ElementTree.parse('library.xml')

for b in root.findall('book'):
	print b.findtext('title')