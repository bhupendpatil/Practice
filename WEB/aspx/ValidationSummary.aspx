<%@ Page Language="C#" AutoEventWireup="true" CodeFile="ValidationSummary.aspx.cs" Inherits="_ValidationSummary" %>

<!DOCTYPE html>

<html>
<head runat="server">
    <title>Validation Summary</title>
</head>
<body>
    <form id="form1" runat="server">
        <asp:TextBox id="TextBox1" runat="server"></asp:TextBox>
        <asp:RangeValidator ID="RangeValidator1" runat="server" ErrorMessage="Between 1 to 10" 
        ControlToValidate="TextBox1" Type="Integer" MaximumValue="10" MinimumValue="1"></asp:RangeValidator>
        <br />
        <asp:Button ID="Button1" runat="server" Text="Ok" />
        <br />
        <asp:ValidationSummary ID="ValidationSummary1" runat="server" />
    </form>
</body>
</html>
