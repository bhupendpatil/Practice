<%@ Page Language="C#" AutoEventWireup="true" CodeFile="CompareValidator.aspx.cs" Inherits="_CompareValidator" %>

<!DOCTYPE html>

<html>
<head runat="server">
    <title>Compare Validator</title>
</head>
<body>
    <form id="form1" runat="server">
        <asp:TextBox ID="TextBox1" runat="server" TextMode="Password"></asp:TextBox>
        <br />
        <asp:TextBox id="TextBox2" runat="server" TextMode="Password"></asp:TextBox>
        <asp:CompareValidator ID="CompareValidator1" runat="server" ErrorMessage="Not Same" 
        ControlToValidate="TextBox2" ControlToCompare="TextBox1"></asp:CompareValidator>
    </form>
</body>
</html>
