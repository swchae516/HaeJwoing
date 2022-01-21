import './app.css';
import Footer from './components/footer/footer';
import Header from './components/header/header';
import Login from './components/login/login';
import NewProfile from './components/profile/newProfile';
import { Link, Route, Switch } from 'react-router-dom';
import MdProfile from './components/profile/mdProfile';

function App() {
  return (
    <div className="App">
      <Header />
      <Switch>
        <Route exact path="/">
          <Login />
        </Route>
        <Route exact path="/newProfile">
          <NewProfile />
        </Route>
        <Route exact path="/mdProfile">
          <MdProfile />
        </Route>
      </Switch>
      <Footer />
    </div>
  );
}

export default App;
