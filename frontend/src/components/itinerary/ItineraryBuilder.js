import React, { useState, useEffect } from "react";
import { DndProvider, useDrag, useDrop } from "react-dnd";
import { HTML5Backend } from "react-dnd-html5-backend";
import axios from "axios";
import "./ItineraryBuilder.scss"; // Import the CSS file

const ItemType = "ACTIVITY";

const ItineraryBuilder = () => {
  const [activities, setActivities] = useState([]);
  const [newActivity, setNewActivity] = useState("");
  const [editingIndex, setEditingIndex] = useState(null);
  const [editingText, setEditingText] = useState("");
  const [savedItineraries, setSavedItineraries] = useState([]); // State for saved itineraries
  const [viewingSaved, setViewingSaved] = useState(false); // State to toggle viewing saved itineraries

  useEffect(() => {
    axios
      .get("/api/itineraries/activities")
      .then((response) => setActivities(response.data))
      .catch((error) => console.error("Error fetching activities:", error));
  }, []);

  const moveActivity = (dragIndex, hoverIndex) => {
    const updatedActivities = [...activities];
    const [removed] = updatedActivities.splice(dragIndex, 1);
    updatedActivities.splice(hoverIndex, 0, removed);
    setActivities(updatedActivities);
  };

  const addActivity = () => {
    if (newActivity.trim() === "") return;
    const newAct = { id: Date.now(), name: newActivity };
    setActivities([...activities, newAct]);
    setNewActivity("");
  };

  const deleteActivity = (index) => {
    const updatedActivities = activities.filter((_, i) => i !== index);
    setActivities(updatedActivities);
  };

  const startEditing = (index) => {
    setEditingIndex(index);
    setEditingText(activities[index].name);
  };

  const saveEditing = () => {
    const updatedActivities = [...activities];
    updatedActivities[editingIndex].name = editingText;
    setActivities(updatedActivities);
    setEditingIndex(null);
    setEditingText("");
  };

  const cancelEditing = () => {
    setEditingIndex(null);
    setEditingText("");
  };

  const saveActivities = () => {
    axios
      .post("/api/itineraries/update", { activities })
      .then(() => alert("Activities saved successfully!"))
      .catch((error) => console.error("Error saving activities:", error));
  };

  const fetchSavedItineraries = () => {
    axios
      .get("/api/itineraries/saved")
      .then((response) => {
        setSavedItineraries(response.data);
        setViewingSaved(true); // Switch to viewing saved itineraries
      })
      .catch((error) => console.error("Error fetching saved itineraries:", error));
  };

  // Handle the Enter key to add activity
  const handleKeyPress = (e) => {
    if (e.key === "Enter") {
      addActivity();
    }
  };

  return (
    <DndProvider backend={HTML5Backend}>
      <div className="itinerary-container">
        <h2>Itinerary Builder</h2>

        {/* Add Activity Form */}
        <div className="add-activity-form">
          <input
            type="text"
            value={newActivity}
            onChange={(e) => setNewActivity(e.target.value)}
            placeholder="Add a new activity"
            className="add-activity-input"
            onKeyDown={handleKeyPress} // Listen for Enter key
          />
          <button onClick={addActivity} className="add-activity-button">
            Add
          </button>
        </div>

        {/* Activity List */}
        {!viewingSaved ? (
          <ActivityList
            activities={activities}
            moveActivity={moveActivity}
            deleteActivity={deleteActivity}
            startEditing={startEditing}
            editingIndex={editingIndex}
            editingText={editingText}
            setEditingText={setEditingText}
            saveEditing={saveEditing}
            cancelEditing={cancelEditing}
          />
        ) : (
          <div>
            <h3>Saved Itineraries</h3>
            <ul>
              {savedItineraries.map((itinerary) => (
                <li key={itinerary.id}>
                  <h4>{itinerary.name}</h4>
                  <p>{itinerary.description}</p>
                </li>
              ))}
            </ul>
          </div>
        )}

        {/* Button Container with side-by-side buttons */}
        <div className="button-container">
          <button onClick={saveActivities} className="save-itinerary-button">
            Save Itinerary
          </button>
          {!viewingSaved && (
            <button onClick={fetchSavedItineraries} className="view-saved-button">
               Saved Itineraries
            </button>
          )}
          {viewingSaved && (
            <button onClick={() => setViewingSaved(false)} className="view-saved-button-back">
              Back to Editing
            </button>
          )}
        </div>
      </div>
    </DndProvider>
  );
};

const Activity = ({
  activity,
  index,
  moveActivity,
  deleteActivity,
  startEditing,
  editingIndex,
  editingText,
  setEditingText,
  saveEditing,
  cancelEditing,
}) => {
  const [, ref] = useDrag({
    type: ItemType,
    item: { index },
  });

  const [, drop] = useDrop({
    accept: ItemType,
    hover: (draggedItem) => {
      if (draggedItem.index !== index) {
        moveActivity(draggedItem.index, index);
        draggedItem.index = index;
      }
    },
  });

  if (editingIndex === index) {
    return (
      <div className="activity-item activity-item-editing">
        <input
          type="text"
          value={editingText}
          onChange={(e) => setEditingText(e.target.value)}
          style={{ width: "70%" }}
        />
        <button onClick={saveEditing} className="activity-edit-buttons">
          Save
        </button>
        <button onClick={cancelEditing} className="activity-edit-buttons">
          Cancel
        </button>
      </div>
    );
  }

  return (
    <div ref={(node) => ref(drop(node))} className="activity-item">
      <span>{activity.name}</span>
      <div>
        <button onClick={() => startEditing(index)} className="activity-edit-buttons">Edit</button>
        <button onClick={() => deleteActivity(index)} className="activity-edit-buttons">
          Delete
        </button>
      </div>
    </div>
  );
};

const ActivityList = ({
  activities,
  moveActivity,
  deleteActivity,
  startEditing,
  editingIndex,
  editingText,
  setEditingText,
  saveEditing,
  cancelEditing,
}) => (
  <div>
    {activities.map((activity, index) => (
      <Activity
        key={activity.id}
        activity={activity}
        index={index}
        moveActivity={moveActivity}
        deleteActivity={deleteActivity}
        startEditing={startEditing}
        editingIndex={editingIndex}
        editingText={editingText}
        setEditingText={setEditingText}
        saveEditing={saveEditing}
        cancelEditing={cancelEditing}
      />
    ))}
  </div>
);

export default ItineraryBuilder;
