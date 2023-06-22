
from flask import Flask, render_template, request
import numpy as np
from sklearn.ensemble import RandomForestClassifier

# Create a Flask app
app = Flask(__name__)

# Load the trained model
model = RandomForestClassifier(n_estimators=100, random_state=42)
model.load_model('model.pkl')  # Load your trained model here

@app.route('/')
def index():
    return render_template('index.html')

@app.route('/predict', methods=['POST'])
def predict():
    code_segment = request.form['code_segment']

    # Preprocess and extract features from the code
    # ...

    # Use the trained model to predict vulnerabilities
    features = extract_features(code_segment)
    prediction = model.predict(features)

    return render_template('index.html', prediction=prediction)

if __name__ == '__main__':
    app.run(debug=True)
