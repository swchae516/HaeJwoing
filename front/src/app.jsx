import './app.css';
import Footer from './components/footer/footer';
import Header from './components/header/header';
import Login from './components/login/login';
import NewProfile from './components/profile/newProfile';

function App() {
  return (
    <div className="App">
      <Header />
      {/* <Login /> */}
      <NewProfile />
      <Footer />
    </div>
  );
}

export default App;
