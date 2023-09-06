<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:template match="/">
        <html>
            <h1>Автомобили в наличии</h1>
            <table border="1">
                <tr>
                    <th>Марка</th>
                    <th>Модель</th>
                    <th>Стоимость</th>
                </tr>
                <xsl:for-each select="shop/car">
                    <xsl:if test="price >= 1000">
                        <tr>
                            <td>
                                <xsl:value-of select="marka"/>
                            </td>
                            <td>
                                <xsl:value-of select="model"/>
                            </td>
                            <td>
                                <xsl:value-of select="price"/>
                            </td>
                        </tr>
                    </xsl:if>
                </xsl:for-each>
            </table>
        </html>
    </xsl:template>
</xsl:stylesheet>