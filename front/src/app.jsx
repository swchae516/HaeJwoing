import './app.css';
import Footer from './components/footer/footer';
import Header from './components/header/header';
import Login from './components/login/login';
import NewProfile from './components/profile/newProfile';
import { Link, Route, Switch } from 'react-router-dom';
import MdProfile from './components/profile/mdProfile';
import Profile from './components/profile/profile';

function App() {
  return (
    <div className="App">
      <Header />
      <Switch>
        <Route exact path="/" component={Login} />
        <Route exact path="/profile" component={Profile} />
        <Route exact path="/mdProfile" component={MdProfile} />
        <Route exact path="/newProfile" component={NewProfile} />
      </Switch>
      <Footer />
    </div>
  );
}

export default App;
