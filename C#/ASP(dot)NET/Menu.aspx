<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Menu.aspx.cs" Inherits="_Menu" %>

<!DOCTYPE html>

<html>
<head runat="server">
    <title>Menu</title>
</head>
<body>
    <form id="form1" runat="server">
        <asp:Menu ID="Menu1" runat="server">
            <Items>
                <asp:MenuItem Text="Home">
                    <asp:MenuItem Text="Try"></asp:MenuItem>
                    <asp:MenuItem Text="Okay"></asp:MenuItem>
                </asp:MenuItem>
                <asp:MenuItem Text="About"></asp:MenuItem>
                <asp:MenuItem Text="Contacts"></asp:MenuItem>
            </Items>
        </asp:Menu>
    </form>
</body>
</html>
