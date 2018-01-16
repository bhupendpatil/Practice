<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html" encoding="UTF-8"/>
<xsl:template match="/">
  <html>
  <body>
    <h2>My CD Collection</h2>
    <table border="1">
      <tr bgcolor="#9acd32">
        <th>BOOKNAME</th>
        <th>AUTHORNAME</th>
        <th>PRICE</th>
      </tr>
      <xsl:for-each select="BOOKINFO/BOOK">
      <tr>
        <td><xsl:value-of select="BOOKNAME"/></td>
		<td><xsl:value-of select="AUTHORNAME"/></td>
		<td><xsl:value-of select="PRICE"/></td>
      </tr>
  		</xsl:for-each>
    </table>
  </body>
  </html>
</xsl:template>
</xsl:stylesheet>

