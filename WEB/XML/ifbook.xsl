<xsl:stylesheet xmlns:nsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

<xsl:template match="/">

<xsl:for-each select="BOOKINFO/BOOK">

<xsl:if test="PRICE[. &gt;=120]">

<xsl:value-of select="BOOKNAME"/> : <xsl:value-of select="PRICE"/><br/>
</xsl:if>

</xsl:for-each>
</xsl:template>
</xsl:stylesheet>