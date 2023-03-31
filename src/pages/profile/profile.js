import React from 'react';

import {
  DataGrid, Column, Editing
} from 'devextreme-react/data-grid';

import CustomStore from 'devextreme/data/custom_store';
import 'whatwg-fetch';

const URL = 'https://js.devexpress.com/Demos/Mvc/api/DataGridWebApi';

const ordersData = ""
class Profile extends React.Component {
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
            mode="popup"
            allowAdding={true}
            allowDeleting={true}
            allowUpdating={true}
          />

          <Column dataField="nombre" caption="Nombre">
          </Column>

          <Column dataField="contrasenya" caption="Contraseña">
          </Column>

          <Column dataField="email" caption="Email">
          </Column>
        </DataGrid>
      </React.Fragment>
    );
  }
}

export default Profile;