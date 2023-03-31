import React from 'react';

import {
  DataGrid, Column, Editing
} from 'devextreme-react/data-grid';

import CustomStore from 'devextreme/data/custom_store';
import { formatDate } from 'devextreme/localization';
import 'whatwg-fetch';



const URL = 'http://localhost:8080/data';


class Task extends React.Component {

  constructor(props) {
    super(props);

    this.state = {
      ordersData: new CustomStore({
        key: 'id',
        load: () => this.sendRequest(`${URL}/getAllPaginated/100/1`),
        insert: (values) => this.sendRequest(`${URL}/AddProducto`, 'POST', {
          values: JSON.stringify(values),
        }),
        update: (key, values) => this.sendRequest(`${URL}/UpdateOrder`, 'PUT', {
          key,
          values: JSON.stringify(values),
        }),
        remove: (key) => this.sendRequest(`${URL}/DeleteOrder`, 'DELETE', {
          key,
        }),
      }),
    };

    this.clearRequests = this.clearRequests.bind(this);
    this.handleRefreshModeChange = this.handleRefreshModeChange.bind(this);
  }

  sendRequest(url, method = 'GET', data = {}) {
    this.logRequest(method, url, data);

    if (method === 'GET') {
      return fetch(url, {
        method,
        headers: {
          'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8',
            credentials: true, 
            origin: '*',
        },
        credentials: 'include',
      }).then((result) => result.json().then((json) => {
        if (result.ok) return json.data;
        throw json.Message;
      }));
    }

    const params = Object.keys(data).map((key) => `${encodeURIComponent(key)}=${encodeURIComponent(data[key])}`).join('&');

    return fetch(url, {
      method,
      body: params,
      headers: {
        'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8',
          credentials: true, 
          origin: '*',
      },
      credentials: 'include',
    }).then((result) => {
      if (result.ok) {
        return result.text().then((text) => text && JSON.parse(text));
      }
      return result.json().then((json) => {
        throw json.Message;
      });
    });
  }

  logRequest(method, url, data) {
    const args = Object.keys(data || {}).map((key) => `${key}=${data[key]}`).join(' ');

    const time = formatDate(new Date(), 'HH:mm:ss');
    const request = [time, method, url.slice(URL.length), args].join(' ');

    this.setState((state) => ({ requests: [request].concat(state.requests) }));
  }

  clearRequests() {
    this.setState({ requests: [] });
  }

  handleRefreshModeChange(e) {
    this.setState({ refreshMode: e.value });
  }

  render() {
    const {
      refreshMode, ordersData
    } = this.state;
    return (
      <React.Fragment>
        <DataGrid
          id="grid"
          showBorders={false}
          dataSource={ordersData}
          repaintChangesOnly={true}
        >
          <Editing
            refreshMode={refreshMode}
            mode="popup"
            allowAdding={true}
            allowDeleting={true}
            allowUpdating={true}
          />

          <Column dataField="nombre" caption="Nombre">
          </Column>

          <Column dataField="descripcion" caption="Descripcion">
          </Column>

          <Column dataField="precio" caption="Precio">
          </Column>
        </DataGrid>
      </React.Fragment>
    );
  }
}

export default Task;