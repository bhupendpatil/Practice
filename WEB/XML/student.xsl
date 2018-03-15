<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match= "/">
	<html>
		<body>
			<h2>Students</h2>
			<xsl:apply-templates select="class/student"/>
		</body>
	</html>
</xsl:template>

<xsl:template match="class/student">
	<xsl:apply-templates select="@rollno"/>
	<xsl:apply-templates select="name"/>
	<xsl:apply-templates select="marks"/>
	<br/>
</xsl:template>

<xsl:template match="@rollno">
	<span style = "font-size:30px;">
		<xsl:value-of select="."/>
	</span>
	<br/>
</xsl:template>

<xsl:template match="name">
	Name : <span style = "color:blue;">
		<xsl:value-of select="."/>
	</span>
	<br/>
</xsl:template>

<xsl:template match="marks">
	Marks : <span style = "color:red;">
		<xsl:value-of select="."/>
	</span>
	<br/>
</xsl:template>

</xsl:stylesheet>