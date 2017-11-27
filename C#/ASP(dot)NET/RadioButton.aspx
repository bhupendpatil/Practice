<%@ Page Language="C#" AutoEventWireup="true" CodeFile="RadioButton.aspx.cs" Inherits="_RadioButton" %>

<!DOCTYPE html>

<html>
<head runat="server">
    <title>RadioButton</title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
        	Gender <br />
        	<asp:RadioButton ID="RadioButton1" runat="server" Text="Male" GroupName="Gender"></asp:RadioButton>
        	<br />
        	<asp:RadioButton ID="RadioButton2" runat="server" Text="Female" GroupName="Gender"></asp:RadioButton>
        </div>
    </form>
</body>
</html>