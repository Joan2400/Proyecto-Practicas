import React from 'react';

import {
  DataGrid, Column, Editing, Link
} from 'devextreme-react/data-grid';

import CustomStore from 'devextreme/data/custom_store';
import 'whatwg-fetch';

const URL = 'https://js.devexpress.com/Demos/Mvc/api/DataGridWebApi';
const ordersData = ""

class Ticket extends React.Component {
  render() {
    return (
      <React.Fragment>
        <DataGrid
          id="grid"
          showBorders={false}
          dataSource={ordersData}
          repaintChangesOnly={true}
        >
          <Editing
            refreshMode={"refreshMode"}
            mode="popup"
            allowAdding={true}
            allowDeleting={true}
            allowUpdating={true}
          />
        
          <Column dataField="id" caption="Id Ticket">
          </Column>
         
        </DataGrid>
      </React.Fragment>
    );
  }
}

export default Ticket;