using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace WcfService1 {
    public class RestServiceImpl : IRestServiceImpl {
        #region IRestServiceImpl Members
        public string XMLData(string id) {
            return "You requested product" + id;
        }
        public string JSONData(string id) {
            return "You requested product" + id;
        }
        #endregion
        public void DoWork(){}
    }
}