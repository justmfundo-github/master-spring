import { useState } from "react";
import { PropTypes } from "prop-types";
import "./Counter.css";

export default function Counter() {
  const [count, setCount] = useState(0);

  function incrementCounterParentFunction(by) {
    setCount(count + by);
  }

  function decrementCounterParentFunction(by) {
    setCount(count - by);
  }

  return (
    <>
      <span className="totalCount">{count}</span>
      <CounterButton by={1} incrementMethod={incrementCounterParentFunction} decrementMethod={decrementCounterParentFunction} />
      <CounterButton by={2} incrementMethod={incrementCounterParentFunction} decrementMethod={decrementCounterParentFunction} />
      <CounterButton by={3} incrementMethod={incrementCounterParentFunction} decrementMethod={decrementCounterParentFunction} />
    </>
  );
}

function CounterButton({ by, incrementMethod, decrementMethod }) {
  // note that state comes with the value and a function. you can access both the value and the function
  // the function acts on the variable
  // [0, function]
  const [count, setCount] = useState(0);

  console.log(by);

  function incrementCounterFunction() {
    setCount(count + by);
    incrementMethod(by);
    console.log(count);

    console.log("increment clicked");
  }

  function decrementCounterFunction() {
    setCount(count - by);
    decrementMethod(by);

    console.log(count);

    console.log("decrement clicked");
  }

  return (
    <div className="Counter">
      <span className="count">{count}</span>
      <div>
        <button className="counterButton" onClick={incrementCounterFunction}>
          +{by}
        </button>
        <button className="counterButton" onClick={decrementCounterFunction}>
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
