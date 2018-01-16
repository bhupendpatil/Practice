<%@ Page Language="C#" AutoEventWireup="true" CodeFile="RequiredField.aspx.cs" Inherits="_RequiredField" %>

<!DOCTYPE html>

<html>
<head runat="server">
    <title>Required Field</title>
</head>
<body>
    <form id="form1" runat="server">
        <asp:TextBox id="TextBox1" runat="server"></asp:TextBox>
        <asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" ErrorMessage="Required" ControlToValidate="TextBox1"></asp:RequiredFieldValidator>
    </form>
</body>
</html>
