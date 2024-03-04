import { PropTypes } from "prop-types";

export default function CounterButton({ by, incrementMethod, decrementMethod }) {
  // note that state comes with the value and a function. you can access both the value and the function
  // the function acts on the variable
  // [0, function]
  //const [count, setCount] = useState(0);

  console.log(by);
  // These two functions are called using arrow function notation in the button onClick call instead
  // function incrementCounterFunction() {
  //   incrementMethod(by);
  // }

  // function decrementCounterFunction() {
  //   decrementMethod(by);
  // }

  return (
    <div className="Counter">
      <div>
        <button className="counterButton" onClick={() => incrementMethod(by)}>
          +{by}
        </button>
        <button className="counterButton" onClick={() => decrementMethod(by)}>
          -{by}
        </button>
      </div>
    </div>
  );
}

CounterButton.propTypes = {
  by: PropTypes.number,
};
CounterButton.defaultProps = {
  by: 5,
};
