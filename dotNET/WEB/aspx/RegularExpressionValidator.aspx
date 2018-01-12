<%@ Page Language="C#" AutoEventWireup="true" CodeFile="RegularExpressionValidator.aspx.cs" Inherits="_RegularExpressionValidator" %>

<!DOCTYPE html>

<html>
<head runat="server">
    <title>Regular Expression Validator</title>
</head>
<body>
    <form id="form1" runat="server">
        <asp:TextBox ID="TextBox1" runat="server"></asp:TextBox>
        <asp:RegularExpressionValidator ID="RegularExpressionValidator1" runat="server" ControlToValidate="TextBox1" ErrorMessage="PinCode invalid" ValidationExpression="\d{6}"></asp:RegularExpressionValidator>
        <br />
    </form>
</body>
</html>
