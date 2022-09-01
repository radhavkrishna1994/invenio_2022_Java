<script type="text/javascript">
function printPDF(pdfUrl) 
{
    var w = window.open(pdfUrl);
    w.print(); 
}
</script>

<a href="${pageContext.request.contextPath}/htmlpages/po1.html"  onClick='printPDF("${pageContext.request.contextPath}/htmlpages/po1.html")'>a</a>