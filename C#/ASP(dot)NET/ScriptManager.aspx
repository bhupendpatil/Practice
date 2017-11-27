<%@ Page Language="C#" AutoEventWireup="true" CodeFile="ScriptManager.aspx.cs" Inherits="_ScriptManager" %>

<!DOCTYPE html>

<html>
<head runat="server">
    <title>Script Manager</title>
</head>
<body>
    <form id="form1" runat="server">
        <asp:ScriptManager ID="ScriptManager1" runat="server">
        </asp:ScriptManager>
        <asp:UpdatePanel ID="UpdatePanel1" runat="server">
            <ContentTemplate>
                <asp:Label ID="Label1" runat="server" Text="Click button for change"></asp:Label>
                <br />
                <asp:Button ID="Button1" runat="server" OnClick="Button1_Click" Text="Button"/>
            </ContentTemplate>
        </asp:UpdatePanel>
    </form>
</body>
</html>

<!-- 

//ScriptManager.aspx.cs

using System;

public partial class _Default : System.Web.UI.Page {
    protected void Button1_Click(object sender, EventArgs e) {
        Label1.Text = "Changed";
    }
}    
    
-->