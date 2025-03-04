import React, { useState, useRef, useEffect } from "react";
import styled from "styled-components";

// const StyledCloseButton = styled.button`
//   background-color: #6c757d; /* Secondary button color */
//   color: white;
//   font-size: 16px;
//   margin-left: 30%;
//   padding: 10px 60px;
//   border: none;
//   border-radius: 5px;
//   cursor: pointer;
//   transition: all 0.3s ease;

//   &:hover {
//     background-color: #5a6268;
//     transform: translateY(-2px);
//     box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
//   }

//   &:focus {
//     outline: none;
//     box-shadow: 0 0 0 3px rgba(108, 117, 125, 0.5);
//   }

//   &:active {
//     transform: translateY(0);
//     box-shadow: inset 0 2px 4px rgba(0, 0, 0, 0.2);
//   }
// `;

const ModalContainer = styled.div`
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
  display: flex;
  justify-content: center;
  align-items: center;
  z-index: 999;
`;

const ModalContent = styled.div`
  background-color: white;
  border-radius: 10px;
  padding: 20px;
  width: ${({ width }) => width || "80%"};
  height: ${({ height }) => height || "auto"};
  max-width: 800px;
  max-height: 80%;
  overflow-y: auto;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
  position: relative;
`;

const ModalHeader = styled.h2`
  margin: 0;
  font-size: 20px;
  font-weight: bold;
  display: flex;
  justify-content: space-between;
  align-items: center;
`;

const CloseButton = styled.button`
  background-color: transparent;
  border: none;
  cursor: pointer;
  font-size: 24px;
  color: #666;
  margin-left:97%;
`;

const Modal = ({ title, isOpen, onClose, children, width, height }) => {
  const [isClosing, setIsClosing] = useState(false);
  const modalRef = useRef(null);

  useEffect(() => {
    const handleOutsideClick = (event) => {
      if (modalRef.current && !modalRef.current.contains(event.target)) {
        setIsClosing(true);
      }
    };

    document.addEventListener("mousedown", handleOutsideClick);
    return () => {
      document.removeEventListener("mousedown", handleOutsideClick);
    };
  }, []);

  const handleClose = () => {
    setIsClosing(true);
    setTimeout(() => {
      onClose();
    }, 200); // Adjust the animation duration as needed
  };

  return (
    <div>
      {isOpen && (
        <ModalContainer>
          <ModalContent ref={modalRef} width={width} height={height}>
            <ModalHeader>
              {title}
              <CloseButton onClick={handleClose}>&times;</CloseButton>
            </ModalHeader>
            {children}
            {/* <div className="text-end mt-5">
            <StyledCloseButton onClick={handleClose}>Close</StyledCloseButton>
            </div> */}
          </ModalContent>
        </ModalContainer>
      )}
    </div>
  );
};

export default Modal;