<%@ Page Language="C#" AutoEventWireup="true" CodeFile="RangeValidator.aspx.cs" Inherits="_RangeValidator" %>

<!DOCTYPE html>

<html>
<head runat="server">
    <title>Range Validator</title>
</head>
<body>
    <form id="form1" runat="server">
        <asp:TextBox id="TextBox1" runat="server"></asp:TextBox>
        <asp:RangeValidator ID="RangeValidator1" runat="server" ErrorMessage="Between 1 to 10" 
        ControlToValidate="TextBox1" Type="Integer" MaximumValue="10" MinimumValue="1"></asp:RangeValidator>
    </form>
</body>
</html>
