import { HomePage, TasksPage, ProfilePage, UsersPage, TicketsPage, DetalleTicketPage } from './pages';
import { withNavigationWatcher } from './contexts/navigation';

const routes = [
    {
        path: '/tasks',
        element: TasksPage
    },
    {
        path: '/profile',
        element: ProfilePage
    },
    {
        path: '/home',
        element: HomePage
    } , 
    {
        path: '/tickets',
        element: TicketsPage
    }, 
  {
    path: '/detalle-ticket',
    element: DetalleTicketPage
  }
];

export default routes.map(route => {
    return {
        ...route,
        element: withNavigationWatcher(route.element, route.path)
    };
});
