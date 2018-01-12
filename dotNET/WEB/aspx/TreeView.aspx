<%@ Page Language="C#" AutoEventWireup="true" CodeFile="TreeView.aspx.cs" Inherits="_TreeView" %>

<!DOCTYPE html>

<html>
<head runat="server">
    <title>Tree View</title>
</head>
<body>
    <form id="form1" runat="server">
        <asp:TreeView ID="Tree1" runat="server">
            <Nodes>
                <asp:TreeNode Text="Home">
                    <asp:TreeNode Text="Try"></asp:TreeNode>
                    <asp:TreeNode Text="Okay"></asp:TreeNode>
                </asp:TreeNode>
                <asp:TreeNode Text="About"></asp:TreeNode>
                <asp:TreeNode Text="Contacts"></asp:TreeNode>
            </Nodes>
        </asp:TreeView>
    </form>
</body>
</html>
